package co.masterclass.ciclo3.ciclo3.model.custom;

public class StatusAmount {
    private Integer complete;
    private Integer cancelled;

    public StatusAmount(Integer complete, Integer cancelled) {
        this.complete = complete;
        this.cancelled = cancelled;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
