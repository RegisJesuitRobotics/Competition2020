/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.CommandGroups.autoNavChallenge;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoMoveAngleCorrect;
import frc.robot.commands.AutoMoveDistance;
import frc.robot.commands.AutoMoveRotate;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class BarrelRace extends SequentialCommandGroup {
  private static double distanceSpeed = 0.7;
  private static double rotateSpeed = 0.7;
  private static double delayTime = 0.5;

  /**
   * Creates a new BarrelRace.
   */
  public BarrelRace() {
    super(
      //1
        new AutoMoveDistance(144, distanceSpeed), 
        new WaitCommand(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitCommand(delayTime),
        //2 
        new AutoMoveDistance(53, distanceSpeed), 
        new WaitCommand(delayTime),
        new AutoMoveRotate(90, rotateSpeed), 
        new WaitCommand(delayTime), 
        //3
        new AutoMoveDistance(64, distanceSpeed),
        new WaitCommand(delayTime), 
        new AutoMoveRotate(90, rotateSpeed), 
        new WaitCommand(delayTime),
        //4
        new AutoMoveDistance(50, distanceSpeed), 
        new WaitCommand(delayTime), 
        new AutoMoveRotate(90, rotateSpeed),
        new WaitCommand(delayTime), 
        new AutoMoveAngleCorrect(0, 0.3),
        new WaitCommand(delayTime),
        //5
        new AutoMoveDistance(140, distanceSpeed), 
        new WaitCommand(delayTime),
        new AutoMoveRotate(-90, rotateSpeed), 
        new WaitCommand(delayTime), 
        //6
        new AutoMoveDistance(65, distanceSpeed),
        new WaitCommand(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed), 
        new WaitCommand(delayTime),
        //7
        new AutoMoveDistance(62, distanceSpeed), 
        new WaitCommand(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitCommand(delayTime),
        new AutoMoveAngleCorrect(90, 0.3),
        new WaitCommand(delayTime),
        //8ci
        new AutoMoveDistance(130, distanceSpeed), 
        new WaitCommand(delayTime), 
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitCommand(delayTime),
        new AutoMoveAngleCorrect(0, 0.3),
        new WaitCommand(delayTime),
        //9
        new AutoMoveDistance(118, distanceSpeed),
        new WaitCommand(delayTime),
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitCommand(delayTime),
        //10
        new AutoMoveDistance(55, distanceSpeed),
        new WaitCommand(delayTime),
        new AutoMoveRotate(-90, rotateSpeed),
        new WaitCommand(delayTime),
        new AutoMoveAngleCorrect(180, 0.3),
        new WaitCommand(delayTime),
        //11
        new AutoMoveDistance(340, distanceSpeed),
        new AutoMoveRotate(360, rotateSpeed)

        );
  }
}
