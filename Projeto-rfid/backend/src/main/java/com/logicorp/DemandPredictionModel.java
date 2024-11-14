import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class DemandPredictionModel {

    private RandomForest model;

    public DemandPredictionModel() {
        model = new RandomForest();
    }

    public Instances loadData(String filePath) throws Exception {
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File(filePath));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);  // A última coluna é o alvo (demand)
        return data;
    }

    public void train(Instances data) throws Exception {
        model.buildClassifier(data);
    }

    public double predictDemand(Instances newData) throws Exception {
        return model.classifyInstance(newData.instance(0));
    }
}
