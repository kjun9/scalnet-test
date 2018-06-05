package stellar.ml

import org.deeplearning4j.nn.conf.{ComputationGraphConfiguration, NeuralNetConfiguration}
import org.deeplearning4j.nn.conf.layers.{DenseLayer, OutputLayer}
import org.deeplearning4j.nn.graph.ComputationGraph
import org.nd4j.linalg.learning.config.Sgd
import org.nd4j.linalg.lossfunctions.LossFunctions

object Hello {

  def buildSimpleConf: ComputationGraphConfiguration =
    new NeuralNetConfiguration.Builder()
      .updater(new Sgd(0.01))
      .graphBuilder().addInputs("input")
      .addLayer("L1", new DenseLayer.Builder().nIn(3).nOut(4).build(), "input")
      .addLayer(
        "out1",
        new OutputLayer.Builder().lossFunction(
          LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD
        ).nIn(4).nOut(3).build(),
        "L1"
      ).addLayer(
      "out2",
      new OutputLayer.Builder().lossFunction(
        LossFunctions.LossFunction.MSE
      ).nIn(4).nOut(2).build(),
        "L1"
      ).setOutputs("out1", "out2").build()

  def buildSimpleCompGraph: ComputationGraph =
    new ComputationGraph(buildSimpleConf)

  def main(args: Array[String]): Unit = {
    println("Hello World!")
    val model = buildSimpleCompGraph
    model.init()
    println("It worked!")
  }
}
