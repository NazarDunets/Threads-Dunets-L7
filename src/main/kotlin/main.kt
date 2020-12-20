import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {

    val counter = AtomicInteger(0)

    val r1 = Runnable{
        counter.incrementAndGet()
    }
    val r2 = Runnable{
        println(counter.get())
    }

    val scheduledEx = Executors.newScheduledThreadPool(5)

    scheduledEx.scheduleAtFixedRate(r2,
        1000,1000,TimeUnit.MILLISECONDS)

    scheduledEx.scheduleAtFixedRate(r1,
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate(r1,
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate(r1,
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate(r1,
        0,10,TimeUnit.MILLISECONDS)

}
