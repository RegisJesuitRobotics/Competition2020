/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Enums.IntakeDirection;
import frc.robot.commands.AutoMove;
import frc.robot.commands.ShooterManual.IntakeDrop;
import frc.robot.commands.ShooterManual.ShooterAim;

public class Auto extends SequentialCommandGroup {
  /**
   * Add your docs here.
   */
  public Auto() {
    super(
      new IntakeDrop(IntakeDirection.REVERSE).withTimeout(0.1),
      // Move forward
      new AutoMove(-0.3, -0.3, 0.3, 0.3).withTimeout(1),
      new ShooterAim(-0.6).withTimeout(1.5)
      // new LimeLightDriveAlign(DirectionEnum.STOP).withTimeout(2.25),
      // new LimeLightShooterAlign(0, 0).withTimeout(2.5),
      // new ShootSequence().withTimeout(6),
      // new AutoMove(0.4, 0.4, 0.4, 0.4).withTimeout(0.6)
    );

  }
}
