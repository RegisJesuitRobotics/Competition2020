package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.ShooterManual.RunBelt;

public class BeltWithWait extends SequentialCommandGroup {
    public BeltWithWait(double seconds, double m_motorSpeed) {
        super(new WaitCommand(seconds), new RunBelt(m_motorSpeed));
    }
}