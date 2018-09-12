package scray.hdfs.io.coordination

import org.scalatest.WordSpec

import com.typesafe.scalalogging.LazyLogging

import java.io.ByteArrayInputStream
import scray.hdfs.io.index.format.sequence.BlobFileReader
import scray.hdfs.io.index.format.sequence.IdxReader
import java.io.File
import java.util.HashMap
import org.junit.Assert


class WriteCoordinatorSpecs extends WordSpec with LazyLogging {
  "WriteCoordinator " should {
    " wrtite to new file if count limit is reached " in {
      val coordinator = new ReadWriteCoordinatorImpl
      val outPath = "target/WriteCoordinatorSpecs/writeCoordinatorSpecsMaxCount/" + System.currentTimeMillis() + "/"

      val metadata = WriteDestination("000", outPath, IHdfsWriterConstats.FileFormat.SequenceFile, Version(0), 512 * 1024 * 1024L, 5)

      val writer = coordinator.getWriter(metadata)
      val writtenData = new HashMap[String, Array[Byte]]();

      for (i <- 0 to 20) {
        writer.insert(s"${i}", System.currentTimeMillis(), new ByteArrayInputStream(s"${i}".getBytes))
        writtenData.put(s"${i}", s"${i}".getBytes)
      }

      writer.close;

      val fileName = getIndexFiles(outPath + "/scray-data-000-v0/")
        .map(fileName => {
          (
            new IdxReader("file://" + fileName + ".idx"),
            new BlobFileReader("file://" + fileName + ".blob"))
        })
        .map {
          case (idxReader, blobReader) => {
            val idx = idxReader.next().get
            val data = blobReader.get(idx.getKey.toString(), idx.getPosition)
            
            val value = writtenData.get(idx.getKey.toString())
            Assert.assertTrue((new String(data.get)).equals(new String(value)))            
          }
        }
    }
  }

  private def getIndexFiles(path: String): List[String] = {
    val file = new File(path)

    file.listFiles()
      .map(file => file.getAbsolutePath)
      .filter(filename => filename.endsWith(".idx"))
      .map(idxFile => idxFile.split(".idx")(0))
      .toList
  }
}