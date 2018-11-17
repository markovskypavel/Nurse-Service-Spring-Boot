package by.bsuir.markovsky.nursewebapp.util.test;

public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
