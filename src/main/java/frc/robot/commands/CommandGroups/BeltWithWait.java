package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ShooterManual.Belt;

class BeltWithWait extends SequentialCommandGroup {
    public BeltWithWait(double seconds, double m_motorSpeed) {
        addCommands(new WaitCommand(seconds));
        addCommands(new Belt(m_motorSpeed));
    }
}