// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutomatedCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.LowerCatapultCommand;
import frc.robot.commands.ReleaseCatapultCommand;
import frc.robot.subsystems.*;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Sixpointer extends SequentialCommandGroup {
  /** Creates a new autonomous command sequence. */
  /*
  move, shoot, move, intake, move shoot, */
  public Gyro gyroAuto;

  public Sixpointer(
      SwerveRotaters rotators,
      SwerveSpinners spinners,
      Gyro gyro,
      Catapult catapult,
      Intake intake) {
    // This is the sequential commands within our autonomous sequence
    gyroAuto = gyro;
    rotators.resetEncoders();
    addCommands(
        new SequentialCommandGroup(
            new IntakeAuto(intake, true),
            new WaitCommand(1),
            new ReleaseCatapultCommand(catapult),
            new WaitCommand(4),
            new LowerCatapultCommand(catapult),
            new MoveForward(rotators, spinners, 2, -1, 0.4)));
  }
}

// move forward, shoot, rotate 15 degrees anti conclic, move direction with 5
