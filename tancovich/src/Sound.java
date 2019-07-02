import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	 
	private static Clip clip;
	
	public static void playSound(String filepath, boolean loop) {
	        
	        try {
	        	File musicPath = new File(filepath);
	        	
	        	if(musicPath.exists()) {
	        		AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
	        		clip = AudioSystem.getClip();
	        		clip.open(audioInput);
	        		clip.start();
	        		
	        		if(loop) {
	        			clip.loop(Clip.LOOP_CONTINUOUSLY);
	        		}
	        		
	        	} else {
	        		System.out.println("No se encontro el archivo");
	        	}
		        
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
	    }
	
	public static void stopSound() {
		clip.stop();
	}
	
}
