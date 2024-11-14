import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.graph.ComputationGraphConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class LocationPredictionModel {

    private ComputationGraph model;

    public LocationPredictionModel() {
        // Definição do modelo (rede neural simples)
        ComputationGraphConfiguration config = new NeuralNetConfiguration.Builder()
            .updater(new org.deeplearning4j.optimize.api.Adam(0.01))
            .list()
            .layer(0, new DenseLayer.Builder().nIn(2).nOut(64).activation(org.nd4j.linalg.activations.Activation.RELU).build())
            .layer(1, new DenseLayer.Builder().nIn(64).nOut(32).activation(org.nd4j.linalg.activations.Activation.RELU).build())
            .layer(2, new OutputLayer.Builder().nIn(32).nOut(2).activation(org.nd4j.linalg.activations.Activation.IDENTITY).build())  // Coordenadas (X, Y)
            .build();

        model = new ComputationGraph(config);
        model.init();
    }

    public void train(INDArray inputData, INDArray outputData) {
        model.fit(inputData, outputData);
    }

    public INDArray predictNextLocation(INDArray inputData) {
        return model.output(inputData)[0];  // Retorna a previsão de X, Y
    }
}
