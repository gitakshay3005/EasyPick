package com.rsi.easypick.utils;

import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.Block;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageContext;
import com.google.cloud.vision.v1.Page;
import com.google.cloud.vision.v1.Paragraph;
import com.google.cloud.vision.v1.Symbol;
import com.google.cloud.vision.v1.TextAnnotation;
import com.google.cloud.vision.v1.Word;
import com.google.protobuf.ByteString;

public class OCRUtils {

	/**
	 * Performs handwritten text detection on a local image file.
	 *
	 * @param filePath The path to the local file to detect handwritten text on.
	 * @param out A {@link PrintStream} to write the results to.
	 * @throws Exception on errors while closing the client.
	 * @throws IOException on Input/Output errors.
	 */
	public static List<String> detectHandwrittenOcr(MultipartFile file) throws Exception {
		
		List<String> scannedStrings = new ArrayList<String>();
		
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ByteString imgBytes = ByteString.readFrom(file.getInputStream());

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build();
		// Set the Language Hint codes for handwritten OCR
		ImageContext imageContext =
				ImageContext.newBuilder().addLanguageHints("en-t-i0-handwrit").build();

		AnnotateImageRequest request =
				AnnotateImageRequest.newBuilder()
				.addFeatures(feat)
				.setImage(img)
				.setImageContext(imageContext)
				.build();
		requests.add(request);

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();
			client.close();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.printf("Error: %s\n", res.getError().getMessage());
					return null;
				}

				// For full list of available annotations, see http://g.co/cloud/vision/docs
				TextAnnotation annotation = res.getFullTextAnnotation();
				for (Page page : annotation.getPagesList()) {
					String pageText = "";
					for (Block block : page.getBlocksList()) {
						String blockText = "";
						for (Paragraph para : block.getParagraphsList()) {
							String paraText = "";
							for (Word word : para.getWordsList()) {
								String wordText = "";
								for (Symbol symbol : word.getSymbolsList()) {
									wordText = wordText + symbol.getText();
									System.out.format(
											"Symbol text: %s (confidence: %f)\n",
											symbol.getText(), symbol.getConfidence());
								}
								System.out.format("Word text: %s (confidence: %f)\n\n", wordText, word.getConfidence());
								paraText = String.format("%s %s", paraText, wordText);
								scannedStrings.add(wordText.trim());
							}
							// Output Example using Paragraph:
							System.out.println("\nParagraph: \n" + paraText);
							System.out.format("Paragraph Confidence: %f\n", para.getConfidence());
							blockText = blockText + paraText;
						}
						pageText = pageText + blockText;
					}
				}
				System.out.println("\nComplete annotation:");
				String scannedText = annotation.getText();
				System.out.println(scannedText);
			}
		}
		
		return scannedStrings;
		
	}

}
