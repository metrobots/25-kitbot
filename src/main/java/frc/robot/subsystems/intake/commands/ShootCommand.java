package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intake.IntakeSubsystem;

public class ShootCommand extends Command {
    private final IntakeSubsystem intake;

    public ShootCommand(IntakeSubsystem subsystem) {
        this.intake = subsystem;
    }

    @Override
    public void initialize() {
        this.intake.stop();
    }

    @Override
    public void execute() {
        this.intake.drive(0.8);
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.stop();
    }
}
