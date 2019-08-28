package cc.wenmin92.regex

import java.util.regex.Pattern

object RegexTest {
    @JvmStatic
    fun main(args: Array<String>) {
        // 参考 http://www.runoob.com/java/java-regular-expressions.html

        val pattern = Pattern.compile("a\\s+")
        val matcher = pattern.matcher("cb a bc")
        println("matcher.find=${matcher.find()}")
        println("matcher.start=${matcher.start()}, matcher.end=${matcher.end()}")


        val pattern2 = Pattern.compile("\\|")
        println("pattern2.split(\"abc|ad|edd.wv\", 2) = ${pattern2.split("abc|ad|edd.wv", 2)!!.contentToString()}")

        val pattern3 = Pattern.compile("""(\d+)\s+bytes from\s+(?:\w.+\s+)?\(?((?:[\d]+.){3}\d+)\)?:\s+icmp_seq=(\d+)\s+ttl=(?<ttl>\d+)(?:\s+time=(?<time>\d+(?:\.\d+)?)\s+ms)?""")
        val matcher3_1 = pattern3.matcher("68 bytes from 220.181.38.149: icmp_seq=1 ttl=53 time=9.71 ms")
        val matcher3_2 = pattern3.matcher("40 bytes from www.baidu.com (180.97.33.108): icmp_seq=1 ttl=54 time=31.1 ms")
        println(matcher3_1.matches())
        println(matcher3_2.matches())
        println(matcher3_2.apply { matches();group(1) })

        val pattern4 = Pattern.compile("""s*""")
        pattern4.matcher("abc").apply {
            println("lookingAt(): ${lookingAt()}")
            println("groupCount(): ${groupCount()}")
            println("group(): ${group()}")
        }

        val pattern5 = Pattern.compile("""(?<=From ).*?((?:[\d.]{2,}){4})""")
        pattern5.matcher("From bogon (192.168.70.254): icmp_seq=1 Time to live exceeded").apply {
            println("find(): ${find()}")
            println("group(): ${group()}")
            println("group(1): ${group(1)}")
        }

        println("Hello\u001b[31m red\u001b[0m world!");
    }
}
