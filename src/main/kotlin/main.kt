import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {

    // This works, since "counter ++" is such a quick operation
    // But... Since we depend on time precision and not number of operations this looks like the best way to go
    var counter = 0

    val scheduledEx = Executors.newScheduledThreadPool(5)

    scheduledEx.scheduleAtFixedRate({println(counter)},
        0,1000,TimeUnit.MILLISECONDS)

    scheduledEx.scheduleAtFixedRate({counter ++},
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({counter ++},
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({counter ++},
        0,10,TimeUnit.MILLISECONDS)
    scheduledEx.scheduleAtFixedRate({counter ++},
        0,10,TimeUnit.MILLISECONDS)

}
