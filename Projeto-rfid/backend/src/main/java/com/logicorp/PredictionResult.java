public class PredictionResult {
    private String productId;
    private double predictedDemand;
    private LocalDateTime predictionTimestamp;

    // Construtores
    public PredictionResult(String productId, double predictedDemand) {
        this.productId = productId;
        this.predictedDemand = predictedDemand;
        this.predictionTimestamp = LocalDateTime.now();
    }

    // Getters e Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getPredictedDemand() {
        return predictedDemand;
    }

    public void setPredictedDemand(double predictedDemand) {
        this.predictedDemand = predictedDemand;
    }

    public LocalDateTime getPredictionTimestamp() {
        return predictionTimestamp;
    }

    public void setPredictionTimestamp(LocalDateTime predictionTimestamp) {
        this.predictionTimestamp = predictionTimestamp;
    }
}
