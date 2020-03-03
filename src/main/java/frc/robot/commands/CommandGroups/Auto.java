/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoMove;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlign;
import frc.robot.commands.LimelightStuff.LimeLightShooterAlignClose;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.IntakeDrop;
import frc.robot.commands.ShooterManual.ShooterAim;
import frc.robot.commands.ShooterManual.ShooterShoot;
import frc.robot.commands.LimelightStuff.LimeLightDriveAlign;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Auto extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Auto() {

    
    // limelight
    NetworkTableInstance instance = NetworkTableInstance.getDefault();
    NetworkTable table = instance.getTable("limelight-limeboi");
    NetworkTableEntry tv = table.getEntry("tv");
    boolean TVboolean = tv.getDouble(0.0) == 1;

    // // backwards
    addSequential(new AutoMove(-.3, 0.3, 1));
    // // drop intake
    //addSequential(new IntakeDrop(1));
    // // thing up
    addSequential(new ShooterAim(-0.6), 1.5);
    addSequential(new LimeLightDriveAlign(-1), 2.25);
    addSequential(new LimeLightShooterAlign(0,1), 2.5);
    addParallel(new ShooterShoot(0.7), 6); //sd autoShoot
    addSequential(new Belt(0), 2);
    addSequential(new Belt(-1), 4);
    addParallel(new ShooterShoot(0), 0.5);
    addSequential(new AutoMove(0.4, 0.4, 0.6));

  }
}
