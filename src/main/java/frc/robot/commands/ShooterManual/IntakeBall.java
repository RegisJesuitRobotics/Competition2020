// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterManual;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeBall extends ParallelRaceGroup {
  /** Creates a new IntakeBall. */
  public IntakeBall() {
    // Add your commands in the addCommands() call, e.g.6u
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new IntakeRun(-0.7), new ShooterShoot(-0.5));
  }
}