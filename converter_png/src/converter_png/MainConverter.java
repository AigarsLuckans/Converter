package converter_png;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainConverter {

	public static void main(String[] args) throws IOException {
		//1 -select file
		//2 - convert jpg to png
		//3 - save file
		System.out.println("Welcome to our converter");

		//Create a file chooser
		JFileChooser chooser = new JFileChooser();
		//choose .jpg image
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Choose JPG format!", "jpg");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		chooser.getSelectedFile().getName().toLowerCase();
		if(chooser.getSelectedFile().getName().charAt(chooser.getSelectedFile().getName().length()-1)=='g' &&
				chooser.getSelectedFile().getName().charAt(chooser.getSelectedFile().getName().length()-2)=='p' &&
				chooser.getSelectedFile().getName().charAt(chooser.getSelectedFile().getName().length()-3)=='j' &&
				chooser.getSelectedFile().getName().charAt(chooser.getSelectedFile().getName().length()-4)=='.'){
			
			//System.out.println(chooser.getSelectedFile().getName().charAt(chooser.getSelectedFile().getName().length()-4));
			String path = chooser.getSelectedFile().getAbsolutePath();
			File file = new File(chooser.getSelectedFile().getName());
			String inputImage = path;
//			System.out.println(path);
//			System.out.println(chooser.getSelectedFile().getParent().toString());
//			System.out.println(chooser.getSelectedFile().getCanonicalPath());
			String outputImage = chooser.getSelectedFile().getParent().toString()+"/resultImage.png";
			String formatName = "PNG";
			//System.out.println(outputImage);
			Convert con = new Convert();
			try {
				boolean result = con.convertFormat(inputImage,
						outputImage, formatName);
				if (result) {
					System.out.println("Image converted successfully.");
				} else {
					System.out.println("Could not convert image.");
				}
			} catch (IOException ex) {
				System.out.println("Error during converting image.");
				ex.printStackTrace();
			}

		}else {
			System.out.println("File is not JPG!");
		}
	}
}

