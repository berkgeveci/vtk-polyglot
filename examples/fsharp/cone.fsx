open Kitware.VTK

let cone = vtkConeSource.New()
cone.SetResolution(8)

let mapper = vtkPolyDataMapper.New()
mapper.SetInputConnection(cone.GetOutputPort())

let actor = vtkActor.New()
actor.SetMapper(mapper)

let renderer = vtkRenderer.New()
renderer.AddActor(actor)
renderer.SetBackground(0.2, 0.3, 0.4)

let window = vtkRenderWindow.New()
window.AddRenderer(renderer)
window.SetSize(640, 480)

let interactor = vtkRenderWindowInteractor.New()
interactor.SetRenderWindow(window)

window.Render()
interactor.Start()
