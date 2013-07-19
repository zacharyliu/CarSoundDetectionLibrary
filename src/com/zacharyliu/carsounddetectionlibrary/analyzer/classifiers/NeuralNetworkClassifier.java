package com.zacharyliu.carsounddetectionlibrary.analyzer.classifiers;

import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;

import com.zacharyliu.carsounddetectionlibrary.analyzer.FeatureVector;
import com.zacharyliu.carsounddetectionlibrary.analyzer.Result;

public class NeuralNetworkClassifier implements Classifier {
	
	private static final int NUMBER_HIDDEN_NEURONS = 20; 
//	private NeuralNetwork network;
	private BasicNetwork network;

	public NeuralNetworkClassifier(int n_inputs, int n_outputs) {
		// Neuroph
//		network = new MultiLayerPerceptron(n_inputs, NUMBER_HIDDEN_NEURONS, NUMBER_HIDDEN_NEURONS, NUMBER_HIDDEN_NEURONS, n_outputs);
		network = new BasicNetwork();
		network.addLayer(new BasicLayer(null, true, n_inputs));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), true, NUMBER_HIDDEN_NEURONS));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), true, NUMBER_HIDDEN_NEURONS));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), true, NUMBER_HIDDEN_NEURONS));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), false, n_outputs));
		network.getStructure().finalizeStructure();
		network.reset();
	}

	@Override
	public Result run(FeatureVector feature_vector) {
		// TODO Run neural network classification
//		Result result = new Result(new double[] {(int) (Math.random() * 10)});
		
		// Neuroph
//		network.setInput(feature_vector.toRawArray());
//		network.calculate();
//		double[] output = network.getOutput();
//		Result result = new Result(output);
//		return result;
		
		// Encog
		MLData output = network.compute(new BasicMLData(feature_vector.toRawArray()));
		Result result = new Result(output.getData());
		return result;
	}

}
