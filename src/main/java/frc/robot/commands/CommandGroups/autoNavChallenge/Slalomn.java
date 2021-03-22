/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Slalomn extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.7;

  /**
   * Creates a new Slalomn.
   */
  public Slalomn() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new AutoMoveDistance(36, distanceSpeed), new AutoMoveRotate(-90, rotateSpeed),
        new AutoMoveDistance(40, distanceSpeed), new AutoMoveRotate(90, rotateSpeed),
        new AutoMoveDistance(115, distanceSpeed), new AutoMoveRotate(90, rotateSpeed),
        new AutoMoveDistance(40, distanceSpeed), new AutoMoveRotate(90, rotateSpeed),
        new AutoMoveDistance(115, distanceSpeed), new AutoMoveRotate(90, rotateSpeed),
        new AutoMoveDistance(40, distanceSpeed), new AutoMoveRotate(-90, rotateSpeed),
        new AutoMoveDistance(36, distanceSpeed));
  }
}
