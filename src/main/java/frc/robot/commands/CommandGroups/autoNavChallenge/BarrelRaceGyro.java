/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveGyro;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class BarrelRaceGyro extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.7;
  private static double delayTime = 0.3;

  /**
   * Creates a new BarrelRace.
   */
  public BarrelRaceGyro() {
    super(new AutoMoveDistance(144, distanceSpeed), new WaitCommand(delayTime), new AutoMoveGyro(90, rotateSpeed),
        new WaitCommand(delayTime), new AutoMoveDistance(53, distanceSpeed), new WaitCommand(delayTime),
        new AutoMoveGyro(90, rotateSpeed), new WaitCommand(delayTime), new AutoMoveDistance(64, distanceSpeed),
        new WaitCommand(delayTime), new AutoMoveGyro(90, rotateSpeed), new WaitCommand(delayTime),
        new AutoMoveDistance(45, distanceSpeed), new WaitCommand(delayTime), new AutoMoveGyro(90, rotateSpeed),
        new WaitCommand(delayTime), new AutoMoveDistance(125, distanceSpeed), new WaitCommand(delayTime),
        new AutoMoveGyro(-90, rotateSpeed), new WaitCommand(delayTime), new AutoMoveDistance(55, distanceSpeed),
        new WaitCommand(delayTime), new AutoMoveGyro(-90, rotateSpeed), new WaitCommand(delayTime),
        new AutoMoveDistance(50, distanceSpeed), new WaitCommand(delayTime), new AutoMoveGyro(-90, rotateSpeed),
        new WaitCommand(delayTime), new AutoMoveDistance(75, distanceSpeed), new WaitCommand(delayTime),
        new AutoMoveGyro(-60, rotateSpeed), new WaitCommand(delayTime), new AutoMoveDistance(145, distanceSpeed),
        new WaitCommand(delayTime), new AutoMoveGyro(240, rotateSpeed), new WaitCommand(delayTime),
        new AutoMoveDistance(300, distanceSpeed), new WaitCommand(delayTime));
  }
}
