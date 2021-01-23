/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.ShooterManual.ShooterShoot;

public class ShootSequence extends ParallelCommandGroup {

  public ShootSequence() {

    super(new ShooterShoot(0.1), new BeltWithWait(2, 0.5));
  }
}
