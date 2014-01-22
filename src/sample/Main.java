package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("Marble Diagram");

        final NumberAxis xAxis = new NumberAxis(); xAxis.setLabel("Time");
        final NumberAxis yAxis = new NumberAxis(10, 30, 1);

        //yAxis.setLowerBound(10);
        //yAxis.setUpperBound(30);
        yAxis.setTickUnit(2);
        yAxis.setTickMarkVisible(false);
        yAxis.setTickLabelsVisible(false);

        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);


        XYChart.Series xs = new XYChart.Series();
        xs.setName("xs");

        xs.getData().add(new XYChart.Data(0, 20));
        xs.getData().add(new XYChart.Data(5, 20));
        xs.getData().add(new XYChart.Data(6, 20));
        xs.getData().add(new XYChart.Data(9, 20));

        XYChart.Series ys = new XYChart.Series();
        xs.setName("xs.map(x => x+1)");

        ys.getData().add(new XYChart.Data(0, 18));
        ys.getData().add(new XYChart.Data(5, 18));
        ys.getData().add(new XYChart.Data(6, 18));
        ys.getData().add(new XYChart.Data(9, 18));

        ScrollPane scrollPane = new ScrollPane();
        Scene scene  = new Scene(scrollPane,800,600);

        lineChart.setPrefWidth(800);
        lineChart.setMinWidth(20000);
        scrollPane.setContent(lineChart);

        lineChart.getData().add(xs);
        lineChart.getData().add(ys);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}