

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.scene.web.WebView;
import javafx.util.Callback;

public class BrowserHistory extends HBox
{
	public BrowserHistory(WebView webView,Button back,Button forward)
	{
		
		

		
	
		
		WebHistory history = webView.getEngine().getHistory();

		
		

		
	
		
		back.setOnAction(ae->{ 
			 history.go(-1);
		});

		forward.setOnAction(ae->{	
			history.go(1);

		});

		
		history.currentIndexProperty().addListener(new ChangeListener<Number>()
		{
		    public void changed(ObservableValue<? extends Number> ov,
		            final Number oldvalue, final Number newvalue)
		    {
				int currentIndex = newvalue.intValue();

				if (currentIndex <= 0)
				{
					back.setDisable(true);
				}
				else
				{
					back.setDisable(false);
				}

				if (currentIndex >= history.getEntries().size())
				{
					forward.setDisable(true);
				}
				else
				{
					forward.setDisable(false);
				}
		    }
		});


		
	
		
		ComboBox<Entry> historyList = new ComboBox<>();
		historyList.setPrefWidth(150);
		historyList.setItems(history.getEntries());

		
		historyList.setCellFactory(new Callback<ListView<WebHistory.Entry>, ListCell<WebHistory.Entry>>()
		{
            @Override public ListCell<WebHistory.Entry> call(ListView<WebHistory.Entry> list)
            {
        		ListCell<Entry> cell = new ListCell<Entry>()
        		{
        			@Override
        			public void updateItem(Entry item, boolean empty)
        			{
        				super.updateItem(item, empty);

        				if (empty)
        				{
        					this.setText(null);
        					this.setGraphic(null);
        				}
        				else
        				{
        					String pageTitle = item.getTitle();
        					this.setText(pageTitle);
						
        				}
        			}
        		};

        		return cell;
            }
        });
		

		
		historyList.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				int currentIndex = history.getCurrentIndex();

				Entry selectedEntry = historyList.getValue();

				int selectedIndex = historyList.getItems().indexOf(selectedEntry);
				int offset = selectedIndex - currentIndex;
				history.go(offset);
			}
		});

	
		

		
		historyList.setTooltip(new Tooltip("history"));
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(historyList);
	}
}
