package lostankit7.android.entry_data.mapper

import lostankit7.android.entry_data.local.entities.LocalUserEntry
import lostankit7.android.entry_domain.entities.Icon
import lostankit7.android.entry_domain.entities.UserEntry
import lostankit7.droid.moodtracker.common.utils.Constants.DB_ENTRY_SEPARATOR

object UserEntryMapper {

    val List<LocalUserEntry>.toUserEntry
        get() = map { it.toUserEntry }

    val UserEntry.toLocalUserEntryInsert: LocalUserEntry
        get() {
            val tIcons = StringBuilder("")
            val tNames = StringBuffer("")

            for (icon in taskIcons) {
                tIcons.append("$DB_ENTRY_SEPARATOR${icon.icon}")
                tNames.append("$DB_ENTRY_SEPARATOR${icon.name}")
            }
            if (tIcons.isEmpty()) tIcons.append(DB_ENTRY_SEPARATOR)
            if (tNames.isEmpty()) tNames.append(DB_ENTRY_SEPARATOR)

            return LocalUserEntry(
                date, time, moodIcon, moodName, tIcons.substring(1), tNames.substring(1), note
            )
        }
    val UserEntry.toLocalUserEntryUpdate
        get() = toLocalUserEntryInsert.also { it.id = id }
    val LocalUserEntry.toUserEntry: UserEntry
        get() {
            val taskIcons = mutableListOf<Icon.Icon>()

            val icons = this.taskIcons.split(DB_ENTRY_SEPARATOR)
            val names = taskNames.split(DB_ENTRY_SEPARATOR)

            icons.forEachIndexed { i, _ ->
                taskIcons.add(Icon.Icon(icon = icons[i], name = names[i]))
            }

            return UserEntry(date, time, moodIcon, moodName, taskIcons, note, id)
        }
}