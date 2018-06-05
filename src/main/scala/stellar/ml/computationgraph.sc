import org.deeplearning4j.nn.graph.ComputationGraph
import org.deeplearning4j.nn.conf.NeuralNetConfiguration
import org.deeplearning4j.nn.conf.layers.{DenseLayer, OutputLayer}
import org.nd4j.linalg.learning.config.Sgd
import org.nd4j.linalg.lossfunctions.LossFunctions

object computationgraph {
  val x = 5

  val conf = new NeuralNetConfiguration.Builder()
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
    ).setOutputs("out1", "out2")
    .build()

  var model = new ComputationGraph(conf)
  model.init()
}

/*
* ComputationGraphConfiguration conf = new NeuralNetConfiguration.Builder()
		.updater(new Sgd(0.01))
        .graphBuilder()
        .addInputs("input")
        .addLayer("L1", new DenseLayer.Builder().nIn(3).nOut(4).build(), "input")
        .addLayer("out1", new OutputLayer.Builder()
                .lossFunction(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                .nIn(4).nOut(3).build(), "L1")
        .addLayer("out2", new OutputLayer.Builder()
                .lossFunction(LossFunctions.LossFunction.MSE)
                .nIn(4).nOut(2).build(), "L1")
        .setOutputs("out1","out2")
        .build();
* */
