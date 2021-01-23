/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Enums.DirectionEnum;
import frc.robot.commands.AutoMove;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterShoot;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;

public class Auto extends SequentialCommandGroup {
  /**
   * Add your docs here.
   */
  public Auto() {

    
    // limelight
    // NetworkTableInstance instance = NetworkTableInstance.getDefault();
    // NetworkTable table = instance.getTable("limelight-limeboi");
    // NetworkTableEntry tv = table.getEntry("tv");
    // boolean TVboolean = tv.getDouble(0.0) == 1;

    // // backwards
    addCommands(
      new AutoMove(-0.3, -0.3, 0.3, 0.3).withTimeout(1),
      new ShooterAim(-0.6).withTimeout(1.5),
      new LimeLightDriveAlign(DirectionEnum.LEFT).withTimeout(2.25),
      new LimeLightShooterAlign(0, 1).withTimeout(2.5),
      new ShooterShoot(0.7).withTimeout(6),
      new Belt(0).withTimeout(2),
      new Belt(-1).withTimeout(4),
      new ShooterShoot(0).withTimeout(0.5),
      new AutoMove(0.4, 0.4, 0.4, 0.4).withTimeout(0.6)

    );

  }
}
