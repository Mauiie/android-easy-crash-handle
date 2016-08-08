package com.mauiie.aech;

/**
 * Created by TaiJL on 2016/8/2.
 */
public class AECHConfiguration {
    private boolean saveToLocal;
    private boolean reportToServer;
    private IAECHReporter reporter;
    private String localFolderPath = null;

    public boolean isSaveToLocal() {
        return saveToLocal;
    }

    public boolean isReportToServer() {
        return reportToServer;
    }

    public IAECHReporter getReporter() {
        return reporter;
    }

    public String getLocalFolderPath() {
        return localFolderPath;
    }

    private AECHConfiguration(Builder builder) {
        this.reporter = builder.reporter;
        this.saveToLocal = builder.saveToLocal;
        this.reportToServer = builder.reportToServer;
        this.localFolderPath = builder.localFolderPath;
    }

    public static class Builder {
        private boolean saveToLocal = true;
        private boolean reportToServer = false;
        private IAECHReporter reporter = null;
        private String localFolderPath = null;

        public Builder setLocalFolderPath(String localFolderPath) {
            this.localFolderPath = localFolderPath;
            return this;
        }

        public Builder setSaveToLocal(boolean saveToLocal) {
            this.saveToLocal = saveToLocal;
            return this;
        }

        public Builder setReportToServer(boolean reportToServer) {
            this.reportToServer = reportToServer;
            return this;
        }

        public Builder setReporter(IAECHReporter reporter) {
            this.reporter = reporter;
            return this;
        }

        public AECHConfiguration build() {
            AECHConfiguration configuration = new AECHConfiguration(this);
            return configuration;
        }
    }

    public interface IAECHReporter {
        void report(Throwable ex);
    }
}
