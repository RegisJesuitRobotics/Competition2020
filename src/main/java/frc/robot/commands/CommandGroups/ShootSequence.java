/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ShooterManual.Belt;
import frc.robot.commands.ShooterManual.ShooterShoot;

public class ShootSequence extends CommandGroup {
 
  public ShootSequence() {
    addParallel(new ShooterShoot(0.1));
    setTimeout(2);
    addParallel(new Belt(0.5));
    
  }
}
