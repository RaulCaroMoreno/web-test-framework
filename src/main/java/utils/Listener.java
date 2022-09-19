package utils;

import java.util.Optional;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

public class Listener implements TestWatcher, BeforeAllCallback, AfterAllCallback, ExtensionContext.Store.CloseableResource{

    private Reports report;
    private boolean anyTestStarted = false;

    public Listener() {
        report = new Reports();
    }

    @Override
    public void testAborted(ExtensionContext extensionContext, Throwable throwable) {
        report.reportSkip();
    }

    @Override
    public void testDisabled(ExtensionContext extensionContext, Optional<String> optional) {
        report.reportFailure(extensionContext.toString());
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        report.reportFailure(throwable.getMessage());
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        report.reportSuccess();
    }


    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        if (!anyTestStarted) {
            anyTestStarted = true;
            report = new Reports();
            report.configReport();
        }else{
            extensionContext.getStore(ExtensionContext.Namespace.GLOBAL).put("report_status", this);
        }
    }

    @Override
    public void close() {
        //Required by extensionContext.Store.CloseableResource
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        report.closeReport();
    }
}
