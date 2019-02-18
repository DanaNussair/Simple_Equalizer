import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.media.*;

public class MainController implements Initializable{
	@FXML private Button importBtn;
	@FXML private TextField path;
	@FXML private Slider slider1;
	@FXML private Slider slider2;
	@FXML private Slider slider3;
	@FXML private Slider slider4;
	@FXML private Slider slider5;
	@FXML private Slider slider6;
	@FXML private Slider slider7;
	@FXML private Slider slider8;
	@FXML private Slider slider9;
	@FXML private Slider slider10;
	@FXML private Slider volumeSlider;

	private File selected_file;
	private MediaPlayer mp;
	private Media song;
	
	@Override 
	public void initialize(URL location, ResourceBundle resources)
	{
		volumeSlider.setValue(100);
		volumeSlider.valueProperty().addListener(new InvalidationListener(){
			@Override
			public void invalidated(Observable observable){
				mp.setVolume(volumeSlider.getValue()/100);
			}
		});
		slider1.setValue(50);
		slider1.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(0).setGain(newValue.doubleValue());
			}
		});
		slider2.setValue(50);
		slider2.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(1).setGain(newValue.doubleValue());
			}
		});
		slider3.setValue(50);
		slider3.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(2).setGain(newValue.doubleValue());
			}
		});
		slider4.setValue(50);
		slider4.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(3).setGain(newValue.doubleValue());
			}
			});
		slider5.setValue(50);
		slider5.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(4).setGain(newValue.doubleValue());
			}
		});
		slider6.setValue(50);
		slider6.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(5).setGain(newValue.doubleValue());
			}
		});
		slider7.setValue(50);
		slider7.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(6).setGain(newValue.doubleValue());
			}
		});
		slider8.setValue(50);
		slider8.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(7).setGain(newValue.doubleValue());
			}
		});
		slider9.setValue(50);
		slider9.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(8).setGain(newValue.doubleValue());
			}
		});
		slider10.setValue(50);
		slider10.valueProperty().addListener(new ChangeListener<Number>(){
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue){
				mp.getAudioEqualizer().getBands().get(9).setGain(newValue.doubleValue());
			}
		});
	}

	public void importFile(ActionEvent event){
		FileChooser fc = new FileChooser();
		fc.setTitle("Open Resource File");
		fc.setInitialDirectory(new File("C:\\Users\\Dana Nussair\\Music"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("MP3 Files", "*.mp3"));
		if(mp != null)
			mp.stop();
		selected_file = fc.showOpenDialog(null);
		
		if (selected_file != null)
		{
			path.setText(selected_file.getAbsolutePath());
			String file_path = path.getText();
			song = new Media(new File(file_path).toURI().toString());
			mp = new MediaPlayer(song);
		}
		else
		{
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error Dialog");
			error.setHeaderText(null);
			error.setContentText("File is not valid!");
			error.showAndWait();
		}
	}
	public void playSong(ActionEvent event){		
		if (selected_file != null || mp.getStatus() == MediaPlayer.Status.PAUSED){
			mp.play();
		} else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error Dialog");
			error.setHeaderText(null);
			error.setContentText("Please import a song first.");
			error.showAndWait();
		}
	}
	public void pauseSong(ActionEvent event){
		if (selected_file != null && mp.getStatus() == MediaPlayer.Status.PLAYING){
			mp.pause();
		} else {
			Alert error = new Alert(AlertType.ERROR);
			error.setTitle("Error Dialog");
			error.setHeaderText(null);
			error.setContentText("Error while pausing.");
			error.showAndWait();
		}
	}
}
