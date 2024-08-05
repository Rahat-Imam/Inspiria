package  com.jetpack.compose.practice.motivation.core.utils.alarmManager

interface NotificationScheduler {
    fun scheduleAlarm(time: Long, message: String, action: String,alarmId: Int)
    fun isAlarmAlreadySchedule(alarmId: Int,action: String): Boolean
    fun cancelAlarmById(alarmId: Int)
}