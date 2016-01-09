package io.opentembo.pos.login;

import com.fasterxml.jackson.core.type.TypeReference;
import io.opentembo.pos.css.StyleService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import ke.co.suncha.tembo.TemboServiceFactory;
import ke.co.suncha.tembo.remote.ConnectionService;
import ke.co.suncha.tembo.remote.Response;
import ke.co.suncha.tembo.tenant.admin.security.Credential;
import ke.co.suncha.tembo.tenant.admin.security.LoginResponse;
import ke.co.suncha.tembo.tenant.admin.security.NdovuSecurityService;
import ke.co.suncha.tembo.tenant.admin.users.roles.UserRole;
import ke.co.suncha.tembo.tenant.admin.users.sessions.UserSession;
import ke.co.suncha.tembo.tenant.helpers.TemboConfig;
import ke.co.suncha.tembo.tenant.helpers.request.ResponseObject;
import ke.co.suncha.tembo.tenant.organization.BusinessUnit;
import ke.co.suncha.tembo.tenant.organization.warehousing.Warehouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by maitha.manyala on 1/8/16.
 */
public class AssignSessionCtrl implements Initializable {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @FXML
    private Label lblWelcome;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnProceed;

    @FXML
    private Label lblStatus;

    @FXML
    private ComboBox<UserRole> cbRoles;

    @FXML
    private ComboBox<BusinessUnit> cbBusinessUnits;

    @FXML
    private ComboBox<Warehouse> cbWarehouses;

    private List<UserRole> userRoles = new ArrayList<>();

    private List<BusinessUnit> businessUnits = new ArrayList<>();

    private List<Warehouse> warehouses = new ArrayList<>();

    @FXML
    public void cancel() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/login/login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(StyleService.CSS_STYLE);
            Stage stage = (Stage) btnCancel.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
        }
    }

    @FXML
    public void proceed() {
        UserRole userRole = cbRoles.getSelectionModel().getSelectedItem();
        BusinessUnit businessUnit = cbBusinessUnits.getSelectionModel().getSelectedItem();
        Warehouse warehouse = cbWarehouses.getSelectionModel().getSelectedItem();
        if (userRole == null) {
            onError("Please select your role");
        } else if (businessUnit == null) {
            onError("Please select a business unit");
        } else if (warehouse == null) {
            onError("Please select a business unit warehouse");
        } else {
            UserSession userSession= new UserSession();
            userSession.setUserRole(userRole);
            userSession.setWarehouse(warehouse);
            userSession.setBusinessUnit(businessUnit);
            ConnectionService connectionService= TemboServiceFactory.getService(ConnectionService.class);
            connectionService.setUserSession(userSession);
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add(StyleService.CSS_STYLE);
                Stage stage = (Stage) btnProceed.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle(TemboConfig.getAppName());
                stage.setFullScreen(true);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
                log.error(ex.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoginResponse loginResponse = TemboServiceFactory.getService(LoginResponse.class);
        lblWelcome.setText("Hallo " + loginResponse.getName() + "\nPlease select your user role and business unit to access OpenTembo services");
        Task task = new Task<Void>() {
            @Override
            protected Void call() {
                getUserRoles();
                return null;
            }
        };
        new Thread(task).start();
    }

    @FXML
    private void onRoleSelected(ActionEvent event) {
        final UserRole userRole = cbRoles.getSelectionModel().getSelectedItem();
        businessUnits = new ArrayList<>();
        cbBusinessUnits.setItems(FXCollections.observableList(businessUnits));

        warehouses = new ArrayList<>();
        cbWarehouses.setItems(FXCollections.observableArrayList(warehouses));

        onError("");
        Task task = new Task<Void>() {
            @Override
            protected Void call() {
                getRoleBusinessUnits(userRole);
                return null;
            }
        };
        new Thread(task).start();
    }

    @FXML
    private void onBusinessUnitSelected(ActionEvent event) {
        onError("");
        final UserRole userRole = cbRoles.getSelectionModel().getSelectedItem();
        warehouses = new ArrayList<>();
        cbWarehouses.setItems(FXCollections.observableArrayList(warehouses));

        final BusinessUnit businessUnit = cbBusinessUnits.getSelectionModel().getSelectedItem();
        onError("");
        Task task = new Task<Void>() {
            @Override
            protected Void call() {
                getBusinessUnitWarehouses(businessUnit);
                return null;
            }
        };
        new Thread(task).start();
    }


    private void getUserRoles() {
        try {
            ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
            NdovuSecurityService ndovuSecurityService = TemboServiceFactory.getService(NdovuSecurityService.class);
            Response response = ndovuSecurityService.getLoggedInUserRoles();
            onUserRolesFetched(response);
        } catch (Exception e) {
            onError(e.getMessage());
            e.printStackTrace();
        }
    }

    private void getRoleBusinessUnits(UserRole userRole) {
        try {
            ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
            NdovuSecurityService ndovuSecurityService = TemboServiceFactory.getService(NdovuSecurityService.class);
            Response response = ndovuSecurityService.getRoleBusinessUnits(userRole);
            onRoleBusinessUnitsFetchedFetched(response);
        } catch (Exception e) {
            onError(e.getMessage());
            e.printStackTrace();
        }
    }

    private void getBusinessUnitWarehouses(BusinessUnit businessUnit) {
        try {
            ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
            NdovuSecurityService ndovuSecurityService = TemboServiceFactory.getService(NdovuSecurityService.class);
            Response response = ndovuSecurityService.getBusinessUnitWarehouses(businessUnit);
            onBusinessUnitWarehousesFetched(response);
        } catch (Exception e) {
            onError(e.getMessage());
            e.printStackTrace();
        }
    }

    private void onUserRolesFetched(final Response response) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    log.error("");
                    ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
                    if (response.isInternalError()) {
                        onError(response.getPayload());
                    } else if (response.isRequestError()) {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        onError(restResponse.getMessage());
                    } else {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        userRoles = connectionService.getMapper().readValue(connectionService.getMapper().writeValueAsString(restResponse.getPayload()), new TypeReference<List<UserRole>>() {
                        });

                        cbRoles.setItems(FXCollections.observableList(userRoles));

                        cbRoles.setCellFactory(new Callback<ListView<UserRole>, ListCell<UserRole>>() {
                            @Override
                            public ListCell<UserRole> call(ListView<UserRole> l) {
                                return new ListCell<UserRole>() {
                                    @Override
                                    protected void updateItem(UserRole item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (item == null || empty) {
                                            setGraphic(null);
                                        } else {
                                            setText(item.getName());
                                        }
                                    }
                                };
                            }
                        });
                        cbRoles.setConverter(new StringConverter<UserRole>() {
                            @Override
                            public String toString(UserRole userRole) {
                                if (userRole == null) {
                                    return null;
                                } else {
                                    return userRole.getName();
                                }
                            }

                            @Override
                            public UserRole fromString(String userId) {
                                return null;
                            }
                        });
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void onRoleBusinessUnitsFetchedFetched(final Response response) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    onError("");
                    ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
                    if (response.isInternalError()) {
                        onError(response.getPayload());
                    } else if (response.isRequestError()) {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        onError(restResponse.getMessage());
                    } else {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        businessUnits = connectionService.getMapper().readValue(connectionService.getMapper().writeValueAsString(restResponse.getPayload()), new TypeReference<List<BusinessUnit>>() {
                        });
                        cbBusinessUnits.setItems(FXCollections.observableList(businessUnits));

                        cbBusinessUnits.setCellFactory(new Callback<ListView<BusinessUnit>, ListCell<BusinessUnit>>() {
                            @Override
                            public ListCell<BusinessUnit> call(ListView<BusinessUnit> l) {
                                return new ListCell<BusinessUnit>() {
                                    @Override
                                    protected void updateItem(BusinessUnit item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (item == null || empty) {
                                            setGraphic(null);
                                        } else {
                                            setText(item.getName());
                                        }
                                    }
                                };
                            }
                        });
                        cbBusinessUnits.setConverter(new StringConverter<BusinessUnit>() {
                            @Override
                            public String toString(BusinessUnit item) {
                                if (item == null) {
                                    return null;
                                } else {
                                    return item.getName();
                                }
                            }

                            @Override
                            public BusinessUnit fromString(String userId) {
                                return null;
                            }
                        });
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void onBusinessUnitWarehousesFetched(final Response response) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    onError("");
                    ConnectionService connectionService = TemboServiceFactory.getService(ConnectionService.class);
                    if (response.isInternalError()) {
                        onError(response.getPayload());
                    } else if (response.isRequestError()) {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        onError(restResponse.getMessage());
                    } else {
                        ResponseObject restResponse = connectionService.getMapper().readValue(response.getPayload(), ResponseObject.class);
                        warehouses = connectionService.getMapper().readValue(connectionService.getMapper().writeValueAsString(restResponse.getPayload()), new TypeReference<List<Warehouse>>() {
                        });

                        cbWarehouses.setItems(FXCollections.observableList(warehouses));

                        cbWarehouses.setCellFactory(new Callback<ListView<Warehouse>, ListCell<Warehouse>>() {
                            @Override
                            public ListCell<Warehouse> call(ListView<Warehouse> l) {
                                return new ListCell<Warehouse>() {
                                    @Override
                                    protected void updateItem(Warehouse item, boolean empty) {
                                        super.updateItem(item, empty);
                                        if (item == null || empty) {
                                            setGraphic(null);
                                        } else {
                                            setText(item.getName());
                                        }
                                    }
                                };
                            }
                        });
                        cbWarehouses.setConverter(new StringConverter<Warehouse>() {
                            @Override
                            public String toString(Warehouse item) {
                                if (item == null) {
                                    return null;
                                } else {
                                    return item.getName();
                                }
                            }

                            @Override
                            public Warehouse fromString(String userId) {
                                return null;
                            }
                        });
                    }
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    private void onError(final String message) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lblStatus.setText(message);
                lblStatus.setTextFill(Color.rgb(210, 39, 30));
            }
        });
    }

}
