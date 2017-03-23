import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import org.apache.spark.storage.StorageLevel
object NetworkSparkStream 
 {
  def main(args: Array[String])
    { 
     val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkStreamApp")
     val ssc = new StreamingContext(conf, Seconds(19))
     val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER_2)
     lines.flatMap (x => x.split(" ") ).map (x => (x,1)).reduceByKey(_+_).print()
     ssc.start() 
     ssc.awaitTermination()     
    }
  }
