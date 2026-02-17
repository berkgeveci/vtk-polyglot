using Kitware.VTK;

class Cone
{
    static void Main()
    {
        var cone = vtkConeSource.New();
        cone.SetResolution(8);

        var mapper = vtkPolyDataMapper.New();
        mapper.SetInputConnection(cone.GetOutputPort());

        var actor = vtkActor.New();
        actor.SetMapper(mapper);

        var renderer = vtkRenderer.New();
        renderer.AddActor(actor);
        renderer.SetBackground(0.2, 0.3, 0.4);

        var window = vtkRenderWindow.New();
        window.AddRenderer(renderer);
        window.SetSize(640, 480);

        var interactor = vtkRenderWindowInteractor.New();
        interactor.SetRenderWindow(window);

        window.Render();
        interactor.Start();
    }
}
