module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.base;
    requires java.desktop;
    
    
    exports hust.soict.globalict.aims.media;
    exports hust.soict.globalict.aims.store;
    exports hust.soict.globalict.aims.screen.customer.controller;
    exports hust.soict.globalict.aims.exception;
    exports hust.soict.globalict.test.screen.customer.store to javafx.graphics;
    
    opens hust.soict.globalict.aims.screen.customer.controller to javafx.fxml;
}
