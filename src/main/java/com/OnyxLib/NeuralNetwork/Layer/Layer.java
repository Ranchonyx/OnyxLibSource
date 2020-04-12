package com.OnyxLib.NeuralNetwork.Layer;

public class Layer{
    private LAYERTYPE type;

    public Layer(LAYERTYPE pType) {
        this.type = pType;
    }

    public LAYERTYPE getType() {
        return type;
    }

}
