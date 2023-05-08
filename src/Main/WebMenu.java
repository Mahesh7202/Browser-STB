

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.web.WebView;

public class WebMenu extends MenuButton {
	public WebMenu(WebView webView)
	{


		SVGPath threedots = new SVGPath();
		threedots.setContent("M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z");
		threedots.setScaleY(1.8);
		threedots.setId("threedots");



		CheckMenuItem ctxMenu = new CheckMenuItem("Enable Context Menu");
		ctxMenu.setSelected(true);

		MenuItem normalFontMenu = new MenuItem("Normal");
		MenuItem biggerFontMenu = new MenuItem("10% Bigger");
		MenuItem smallerFontMenu = new MenuItem("10% Smaller");

		MenuItem normalZoomMenu = new MenuItem("Normal");
		MenuItem biggerZoomMenu = new MenuItem("10% Bigger");
		MenuItem smallerZoomMenu = new MenuItem("10% Smaller");

		// Create the RadioMenuItems
		RadioMenuItem grayMenu = new RadioMenuItem("GRAY");
		grayMenu.setSelected(true);
		RadioMenuItem lcdMenu = new RadioMenuItem("LCD");

		// Create the Menus
		Menu scalingMenu = new Menu("Font Scale");
		scalingMenu.textProperty().bind(new SimpleStringProperty("Font Scale ").concat(webView.fontScaleProperty().multiply(100.0)).concat("%"));

		Menu smoothingMenu = new Menu("Font Smoothing");

		Menu zoomMenu = new Menu("Zoom");
		zoomMenu.textProperty().bind(new SimpleStringProperty("Zoom ").concat(webView.zoomProperty().multiply(100.0)).concat("%"));

		MenuItem Exit = new MenuItem("Exit");
		
		// Add  the Items to the corresponding Menu
		scalingMenu.getItems().addAll(normalFontMenu, biggerFontMenu, smallerFontMenu);
		smoothingMenu.getItems().addAll(grayMenu, lcdMenu);
		zoomMenu.getItems().addAll(normalZoomMenu, biggerZoomMenu, smallerZoomMenu);
		

		// Create the ToggleGroup
		new ToggleGroup().getToggles().addAll(lcdMenu, grayMenu);

		// Define the Event Handler
		normalFontMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setFontScale(1.0);
			}
		});

		biggerFontMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setFontScale(webView.getFontScale() + 0.10);
			}
		});

		smallerFontMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setFontScale(webView.getFontScale() - 0.10);
			}
		});

		grayMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setFontSmoothingType(FontSmoothingType.GRAY);
			}
		});

		lcdMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setFontSmoothingType(FontSmoothingType.LCD);
			}
		});

		normalZoomMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setZoom(1.0);
			}
		});

		biggerZoomMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setZoom(webView.getZoom() + 0.10);
			}
		});

		smallerZoomMenu.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				webView.setZoom(webView.getZoom() - 0.10);
			}
		});
		Exit.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				Platform.exit();
			}
		});


		webView.contextMenuEnabledProperty().bind(ctxMenu.selectedProperty());

		// Enabled JavaScript option
		CheckMenuItem scriptMenu = new CheckMenuItem("Enable JavaScript");
		scriptMenu.setSelected(true);
		webView.getEngine().javaScriptEnabledProperty().bind(scriptMenu.selectedProperty());

		// Add Menus to the WebMenu

		this.setTooltip(new Tooltip("options"));



		this.setGraphic(threedots);
		this.setId("menubutton");
		this.setAlignment(Pos.CENTER);

		this.getItems().addAll(ctxMenu, scalingMenu, smoothingMenu, zoomMenu, new SeparatorMenuItem(), scriptMenu , Exit);
	}


}
