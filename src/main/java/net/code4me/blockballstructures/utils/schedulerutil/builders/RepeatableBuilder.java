package net.code4me.blockballstructures.utils.schedulerutil.builders;

import lombok.Getter;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleBuilderBase;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleData;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleThread;
import net.code4me.blockballstructures.utils.schedulerutil.data.ScheduleTimestamp;

public class RepeatableBuilder extends ScheduleThread implements ScheduleBuilderBase {

    @Getter
    private final ScheduleData data;


    RepeatableBuilder(ScheduleData data) {
        super(data);
        this.data = data;
    }

    public ScheduleTimestamp<ScheduleThread> during(long amount) {
        return new ScheduleTimestamp<>(new ScheduleThread(data), amount, data::setCancelIn);
    }
}
