name := "scalnet-test"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.5",
  "org.deeplearning4j" % "scalnet_2.11" % "1.0.0-beta",
  "org.nd4j" % "nd4j-native-platform" % "1.0.0-beta" % Runtime,
  "org.deeplearning4j" % "deeplearning4j-core" % "1.0.0-beta",
  "org.deeplearning4j" % "deeplearning4j-modelimport" % "1.0.0-beta",
  "org.apache.spark" % "spark-core_2.11" % "2.1.2"
)