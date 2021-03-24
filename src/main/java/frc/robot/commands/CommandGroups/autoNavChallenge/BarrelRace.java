/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveToRotation;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class BarrelRace extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.7;

  /**
   * Creates a new BarrelRace.
   */
  public BarrelRace() {
    super(new AutoMoveDistance(138, distanceSpeed), new AutoMoveToRotation(80, rotateSpeed),
        new AutoMoveDistance(53, distanceSpeed), new AutoMoveToRotation(180, rotateSpeed),
        new AutoMoveDistance(55, distanceSpeed), new AutoMoveToRotation(270, rotateSpeed),
        new AutoMoveDistance(39, distanceSpeed), new AutoMoveToRotation(1, rotateSpeed),
        new AutoMoveDistance(125, distanceSpeed), new AutoMoveToRotation(270, rotateSpeed),
        new AutoMoveDistance(55, distanceSpeed), new AutoMoveToRotation(180, rotateSpeed),
        new AutoMoveDistance(50, distanceSpeed), new AutoMoveToRotation(90, rotateSpeed),
        new AutoMoveDistance(75, distanceSpeed), new AutoMoveToRotation(30, rotateSpeed),
        new AutoMoveDistance(145, distanceSpeed), new AutoMoveToRotation(270, rotateSpeed),
        new AutoMoveDistance(300, distanceSpeed));
  }
}
