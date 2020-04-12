package com.OnyxLib.NeuralNetwork.Node;
import com.OnyxLib.NeuralNetwork.Layer.LAYERTYPE;
import com.OnyxLib.NeuralNetwork.Layer.Layer;

public class Node {

private long biasHighest = 1L;
private long biasLowest = -1L;
private Layer layer;
private long bias;
private long primaryInput;
private long secondaryInput;
private long output;
private long result;

    public Node(Layer pLayer, long pBias) {
        this.layer = pLayer;
        this.bias = pBias;
        if(this.layer.getType() != LAYERTYPE.HIDDEN) {
            //If this Node's parent Layer is not a hidden processing layer, set the bias to 0 as only hidden layers utilize bias
            this.bias = 0L;
        } else {
            //Initialize Node with random bias between -1L and 1L
            this.bias = biasLowest + (long) (Math.random() * (biasHighest - biasLowest));
        }
    }

    public long getBias() {
        return bias;
    }

    public Layer getLayer() {
        return layer;
    }

    public void setPrimaryInputInput(long pInput) {
        this.primaryInput = pInput;
    }

    public void setSecondaryInput(long pInput) {
        this.secondaryInput = pInput;
    }

    public long getOutput () {
        return this.output;
    }

    public void calculate() {
        if(this.layer.getType() == LAYERTYPE.HIDDEN) {
            this.result = (primaryInput + secondaryInput) + this.bias;
        } else {
            System.out.println("Cannot calculate, node type is either input or output");
        }
    }

}
