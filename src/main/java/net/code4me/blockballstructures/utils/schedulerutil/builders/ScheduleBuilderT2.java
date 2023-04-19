package net.code4me.blockballstructures.utils.schedulerutil.builders;

import lombok.Getter;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleBuilderBase;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleData;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleThread;

public class ScheduleBuilderT2 implements ScheduleBuilderBase {

    @Getter
    private final ScheduleData data;

    ScheduleBuilderT2(ScheduleData data) {
        this.data = data;
    }

    public ScheduleThread run(Runnable runnable) {
        data.setRunnable(runnable);
        return new ScheduleThread(data);
    }

}
