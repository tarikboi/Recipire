module org.openjfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires unirest.java;
    requires json.simple;
    requires java.net.http;
    requires java.datatransfer;
    requires java.desktop;


    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}
