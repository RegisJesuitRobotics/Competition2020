// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TestAuto extends SequentialCommandGroup {
  /** Creates a new TestAuto. */
  public TestAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new AutoMoveDistance(360, 0.7), new AutoMoveRotate(-90, 0.7), new AutoMoveDistance(75, 0.7),
        new AutoMoveRotate(-90, 0.7), new AutoMoveDistance(360, 0.7));
  }
}
