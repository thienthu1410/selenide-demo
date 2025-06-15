package reportportal;

import java.io.File;
import java.util.Date;

import com.codeborne.selenide.Screenshots;
import com.epam.reportportal.service.ReportPortal;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;

public class CustomizeStepFailedListener implements ConcurrentEventListener {

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::onStepFinished);
    }

    private void onStepFinished(TestStepFinished event) {
        if (event.getResult().getStatus() == Status.FAILED) {
            File screenshot = Screenshots.getLastScreenshot();
            if (screenshot != null && screenshot.exists()) {
                ReportPortal.emitLog(
                    "",
                    "ERROR",
                    new Date(),
                   screenshot)
                ;
            }
        }
    }
    
}
