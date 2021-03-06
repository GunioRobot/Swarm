package swarm.demos

import swarm.{Swarm, NoBee}
import swarm.data.Ref
import swarm.transport.{Transporter, InetTransporter}

object ForceRemoteRef {
  def main(args: Array[String]) = {
    implicit val tx: Transporter = InetTransporter
    InetTransporter.listen(9999)
    Swarm.spawn(frrThread)
  }

  def frrThread = {
    println("1")
    val vLoc = Ref(InetTransporter.local, "test local string")
    println("2")
    val vRem = Ref(InetTransporter.local, "test remote string")
    println("3")
    println(vLoc())
    println("4")
    println(vRem())
    println("5")
    NoBee()
  }
}
