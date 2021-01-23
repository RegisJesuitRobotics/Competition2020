/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Enums.DirectionEnum;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;

public class LimelightCommand extends ParallelCommandGroup {
  /**
   * Add your docs here.
   */
  public LimelightCommand() {
    addCommands(new LimeLightDriveAlign(DirectionEnum.STOP), new LimeLightShooterAlign(0, 0));
  }
}
